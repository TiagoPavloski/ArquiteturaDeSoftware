import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/Rx';
import { Empresa } from './empresa.component'

@Injectable()
export class HttpEmpresaService {
  constructor(private _http: Http) { }

  getEmpresas(): Observable<Empresa[]> {
    return this._http.get('http://norvana.jelasticlw.com.br//Norvana/rest/empresarest').
      map(this.extractData);
  }

  private extractData(res: Response) {
    return res.json()['empresa'];
  }

  addEmpresa(empresa: Empresa): Observable<string> {
    const json = JSON.stringify(empresa);
    const headers = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: headers });
    return this._http.post('http://norvana.jelasticlw.com.br/Norvana/rest/empresarest',
      json, options).map(res => res.json());
  }
}
