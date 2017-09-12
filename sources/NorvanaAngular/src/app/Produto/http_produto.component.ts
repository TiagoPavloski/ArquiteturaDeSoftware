import { Component } from '@angular/core';
import { HttpProdutoService } from './http_produto.service'
import { Produto } from './produto.component'

@Component({
  selector: 'app-root',
  templateUrl: './http_produto.component.html',
  providers: [HttpProdutoService]
})
export class HttpProdutoComponent {
  produtos: Produto[];
  produto: Produto;

  constructor(private httpProdutoS: HttpProdutoService) {
    this.produto = new Produto();
    this.getProdutos();
  }

  getProdutos() {
    this.httpProdutoS.getProdutos().subscribe(
      produtos => this.produtos = produtos,
      error => alert(error),
      () => console.log('terminou')
    );
  }

  addProduto() {
    this.httpProdutoS.addProduto(this.produto).subscribe(
      data => data,
      error => alert(error),
      () => this.getProdutos()
    );


  }


}
