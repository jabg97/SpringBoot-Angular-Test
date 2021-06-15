import {
  BrowserAnimationsModule
} from "@angular/platform-browser/animations";
import {
  HttpClientModule
} from "@angular/common/http";
import {
  FormsModule,
  ReactiveFormsModule
} from "@angular/forms";
import {
  BrowserModule
} from "@angular/platform-browser";
import {
  FlexLayoutModule
} from "@angular/flex-layout";
import {
  LayoutModule
} from "@angular/cdk/layout";
import {
  NgModule
} from "@angular/core";

import {
  AppRoutingModule,
  RoutingComponents
} from "./app-routing.module";
import {
  ScreenBreakpointService
} from "./services/breakpoint.service";
import {
  SideNavService
} from "./services/side-nav.service";
import {
  MaterialModule
} from "./components/material/material.module";
import {
  ApiService
} from "./services/api.service";
import {
  DataService
} from "./services/data.service";
import {
  AppComponent
} from "./app.component";
import {
  MatSnackBarModule
} from '@angular/material/snack-bar';
import {
  NgxSpinnerModule
} from "ngx-spinner";
@NgModule({
  declarations: [
    AppComponent,
    RoutingComponents,
  ],
  imports: [
    BrowserAnimationsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpClientModule,
    FlexLayoutModule,
    MaterialModule,
    BrowserModule,
    LayoutModule,
    FormsModule,
    MatSnackBarModule,
    NgxSpinnerModule
  ],
  bootstrap: [AppComponent],
  providers: [
    ScreenBreakpointService,
    SideNavService,
    ApiService,
    DataService,
  ]
})
export class AppModule {}
