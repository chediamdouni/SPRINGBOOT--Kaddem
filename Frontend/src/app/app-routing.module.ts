import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateComponent } from './etudiant/create/create.component';
import { DetailsComponent } from './etudiant/details/details.component';
import { HomeComponent } from './etudiant/home/home.component';
import { UpdateComponent } from './etudiant/update/update.component';

const routes: Routes = [
  {path: 'home', component :HomeComponent},
  {path: 'create', component :CreateComponent},
  {path: 'Details', component :DetailsComponent},
  {path: 'Update', component :UpdateComponent},
 { path: 'etudiant', loadChildren: () => import('./etudiant/etudiant.module').then(m => m.EtudiantModule) }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
