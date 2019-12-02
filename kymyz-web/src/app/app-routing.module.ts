import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CommandsComponent} from './components/commands/commands.component';


const routes: Routes = [
  {path: 'commands', component: CommandsComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
