import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { HttpProdutoComponent } from './Produto/http_produto.component';



@NgModule({
  declarations: [
    AppComponent,
    HttpProdutoComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot([
  {
    path: 'produto',
    component: HttpProdutoComponent
  }
])
  ],
  providers: [HttpProdutoComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
