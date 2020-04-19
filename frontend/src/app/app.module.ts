import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { LoadingBarHttpClientModule } from '@ngx-loading-bar/http-client';
import { LoadingBarRouterModule } from '@ngx-loading-bar/router';
import { GoogleMapsModule } from '@angular/google-maps';
import { ChartsModule } from 'ng2-charts';
import { NgxWebstorageModule } from 'ngx-webstorage';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { HeaderComponent } from './elements/header/header.component';
import { FooterComponent } from './elements/footer/footer.component';
import { HomeComponent } from './pages/home/home.component';
import { MerchComponent } from './pages/merch/merch.component';
import { EventsComponent } from './pages/events/events.component';
import { AboutUsComponent } from './pages/about-us/about-us.component';
import { ContactComponent } from './pages/contact/contact.component';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { EventsDashComponent } from './pages/dashboard/events-dash/events-dash.component';
import { MerchDashComponent } from './pages/dashboard/merch-dash/merch-dash.component';
import { UsersDashComponent } from './pages/dashboard/users-dash/users-dash.component';
import { EventsFormComponent } from './pages/events/events-form/events-form.component';
import { LcddMapComponent } from './elements/lcdd-map/lcdd-map.component';
import { ErrorComponent } from './pages/error/error.component';
import { EventsBarChartComponent } from './elements/events-bar-chart/events-bar-chart.component';
import { MerchLineChartComponent } from './elements/merch-line-chart/merch-line-chart.component';
import { MerchTemplateComponent } from './pages/merch/merch-template/merch-template.component';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthInterceptor } from './interceptors/auth.interceptor';
import { ErrorInterceptor } from './interceptors/error.interceptor';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { EventTemplateComponent } from './pages/events/event-template/event-template.component';
import { HttpClientModule } from '@angular/common/http';
import { ProfileComponent } from './pages/profile/profile.component';
import { MerchFormComponent } from './pages/merch/merch-form/merch-form.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    MerchComponent,
    EventsComponent,
    AboutUsComponent,
    ContactComponent,
    LoginComponent,
    RegisterComponent,
    DashboardComponent,
    EventsDashComponent,
    MerchDashComponent,
    UsersDashComponent,
    EventsFormComponent,
    LcddMapComponent,
    ErrorComponent,
    EventsBarChartComponent,
    MerchLineChartComponent,
    EventTemplateComponent,
    MerchTemplateComponent,
    ProfileComponent,
    MerchFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FontAwesomeModule,
    LoadingBarHttpClientModule,
    LoadingBarRouterModule,
    GoogleMapsModule,
    ChartsModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgxWebstorageModule.forRoot(),
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
