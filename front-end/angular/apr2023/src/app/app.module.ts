import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';
import { HeaderComponent } from './header/header.component';
// to enable 2 way data binding
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SquarePipe } from './square.pipe';
import { FooterComponent } from './footer/footer.component';
import { AlertComponent } from './alert/alert.component';
import { ServiceComponent } from './web/service/service.component';
import { HomeComponent as webHomeComponent} from './web/home/home.component';
import {ContactComponent as webContactComponent} from './web/contact/contact.component';
import { AboutComponent as webAboutComponent} from './web/about/about.component';
import { WebHeaderComponent } from './web/web-header/web-header.component';
import { FooterComponent as WebFooterComponent } from './web/footer/footer.component';
import { AdminPageComponent } from './web/admin-page/admin-page.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AboutComponent,
    ContactComponent,
    HeaderComponent,
    SquarePipe,
    FooterComponent,
    AlertComponent,
    ServiceComponent,
    webHomeComponent,
    webContactComponent,
    webAboutComponent,
    WebHeaderComponent,
    WebFooterComponent,
    AdminPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
