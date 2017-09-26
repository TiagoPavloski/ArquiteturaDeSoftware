import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/Rx';
import { Produto } from './produto.component'

@Injectable()
export class HttpProdutoService {
  constructor(private _http: Http) { }

  getProdutos(): Observable<Produto[]> {
    return this._http.get('http://norvana.jelasticlw.com.br/Norvana/rest/produtorest').
      map(this.extractData);
  }

  private extractData(res: Response) {
    return res.json()['produto'];
  }

  addProduto(produto: Produto): Observable<string> {
    const json = JSON.stringify(produto);
    const headers = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: headers });
    return this._http.post('http://norvana.jelasticlw.com.br/Norvana/rest/produtorest',
      json, options).map(res => res.json());
  }

  excluirProduto(id: number): Observable<string> {
    const json = JSON.stringify(id);
    const headers = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: headers });
    return this._http.post('http://norvana.jelasticlw.com.br/Norvana/rest/produtorest/excluir?id=' + id,
      json, options).map(res => res.json());
  }
}
