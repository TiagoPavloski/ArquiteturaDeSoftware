import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
<a routerLink="/local" routerLinkActive="active">Local</a>
<router-outlet></router-outlet>`
})
export class AppComponent {
}
