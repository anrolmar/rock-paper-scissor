import { AppComponent } from './app.component';
import { BrowserModule } from '@angular/platform-browser';
import { ChoiceComponent } from './components/choice/choice.component';
import { GameComponent } from './components/game/game.component';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { ResultComponent } from './components/result/result.component';

@NgModule({
  declarations: [AppComponent, GameComponent, ChoiceComponent, ResultComponent],
  imports: [BrowserModule, HttpClientModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
