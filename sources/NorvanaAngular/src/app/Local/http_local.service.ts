import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/Rx';
import { Local } from './local.component'

@Injectable()
export class HttpLocalService {
  constructor(private _http: Http) { }

  getLocais(): Observable<Local[]> {
    return this._http.get('http://localhost:9090/Norvana/rest/localrest').
      map(this.extractData);
  }

  private extractData(res: Response) {
    return res.json()['local'];
  }

  addLocal(local: Local): Observable<string> {
    const json = JSON.stringify(local);
    const headers = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: headers });
    return this._http.post('http://localhost:9090/Norvana/rest/localrest',
      json, options).map(res => res.json());
  }
}
