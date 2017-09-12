import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/Rx';
import { Cliente } from './cliente.component'

@Injectable()
export class HttpClienteService {
  constructor(private _http: Http) { }

  getClientes(): Observable<Cliente[]> {
    return this._http.get('http://aulaas.jelasticlw.com.br/sistemadevendas/rest/clienterest').
      map(this.extractData);
  }

  private extractData(res: Response) {
    return res.json()['cliente'];
  }

  addCliente(cliente: Cliente): Observable<string> {
    const json = JSON.stringify(cliente);
    const headers = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: headers });
    return this._http.post('http://aulaas.jelasticlw.com.br/sistemadevendas/rest/clienterest',
      json, options).map(res => res.json());
  }
}
