import { Component } from '@angular/core';
import { HttpLocalService } from './http_local.service'
import { Local } from './local.component'

@Component({
  selector: 'app-root',
  templateUrl: './http_local.component.html',
  providers: [HttpLocalService]
})
export class HttpLocalComponent {
  locais: Local[];
  local: Local;

  constructor(private httpLocalS: HttpLocalService) {
    this.local = new Local();
    this.getLocais();
  }

  getLocais() {
    this.httpLocalS.getLocais().subscribe(
      locais => this.locais = locais,
      error => alert(error),
      () => console.log('terminou')
    );
  }

  addLocal() {
    this.httpLocalS.addLocal(this.local).subscribe(
      data => data,
      error => alert(error),
      () => this.getLocais()
    );
    this.limparTela();
  }

  excluirLocal(id: number) {
    this.httpLocalS.excluirLocal(id).subscribe(
      data => data,
      error => alert(error),
      () => this.getLocais()
    );
  }

  limparTela() {
    this.local.id = null;
    this.local.codigo = '' ;
    this.local.descricao = '';
  }

   editarLocal(local: Local) {
    this.local.id = local.id;
    this.local.codigo = local.codigo;
    this.local.descricao = local.descricao;
  }

}
