import { Component } from '@angular/core';
import { HttpClienteService } from './http_cliente.service'
import { Cliente } from './cliente.component'

@Component({
  selector: 'app-root',
  templateUrl: './http_cliente.component.html',
  providers: [HttpClienteService]
})
export class HttpCliente {
  clientes: Cliente[];
  cliente: Cliente;

  constructor(private httpClienteS: HttpClienteService) {
    this.cliente = new Cliente();
    this.getClientes();
  }

  getClientes() {
    this.httpClienteS.getClientes().subscribe(
      clientes => this.clientes = clientes,
      error => alert(error),
      () => console.log("terminou")
    );
  }

  addCliente() {
    this.httpClienteS.addCliente(this.cliente).subscribe(
      data => data,
      error => alert(error),
      () => this.getClientes()
    );


  }


}
