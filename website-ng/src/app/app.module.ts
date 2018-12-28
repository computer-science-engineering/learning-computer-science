import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';

import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import {NgMaterialWrapperModule} from './ng-material-wrapper/ng-material-wrapper.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    NgMaterialWrapperModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
