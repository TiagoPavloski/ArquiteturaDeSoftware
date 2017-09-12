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
    return this._http.get('http://localhost:8080/Norvana/rest/produtorest').
      map(this.extractData);
  }

  private extractData(res: Response) {
    return res.json()['produto'];
  }

  addProduto(produto: Produto): Observable<string> {
    const json = JSON.stringify(produto);
    const headers = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: headers });
    return this._http.post('http://localhost:8080/Norvana/rest/produtorest',
      json, options).map(res => res.json());
  }
}
