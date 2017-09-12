import { Component } from '@angular/core';
import { HttpEmpresaService } from './http_empresa.service'
import { Empresa } from './empresa.component'

@Component({
  selector: 'app-root',
  templateUrl: './http_empresa.component.html',
  providers: [HttpEmpresaService]
})
export class HttpProdutoComponent {
  empresas: Empresa[];
  empresa: Empresa;

  constructor(private httpEmpresaS: HttpEmpresaService) {
    this.empresa = new Empresa();
    this.getEmpresas();
  }

  getEmpresas() {
    this.httpEmpresaS.getEmpresas().subscribe(
      empresas => this.empresas = empresas,
      error => alert(error),
      () => console.log('terminou')
    );
  }

  addEmpresa() {
    this.httpEmpresaS.addEmpresa(this.empresa).subscribe(
      data => data,
      error => alert(error),
      () => this.getEmpresas()
    );


  }


}
