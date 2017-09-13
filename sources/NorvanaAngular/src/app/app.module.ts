import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { HttpProdutoComponent } from './Produto/http_produto.component';
import { HttpLocalComponent } from './Local/http_local.component';
import { HttpUsuarioComponent } from './Usuario/http_usuario.component';



@NgModule({
  declarations: [
    AppComponent,
    HttpProdutoComponent,
    HttpLocalComponent,
    HttpUsuarioComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot([
  {
    path: 'produto',
    component: HttpProdutoComponent
  },

  {
    path: 'local',
    component: HttpLocalComponent
  },
      {
      path: 'usuario',
      component: HttpUsuarioComponent
      }
])
  ],
  providers: [HttpLocalComponent, HttpUsuarioComponent, HttpProdutoComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
