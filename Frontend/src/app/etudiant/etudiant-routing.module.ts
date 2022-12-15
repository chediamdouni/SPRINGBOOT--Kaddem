import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';
import { CreateComponent } from './create/create.component';
import { DetailsComponent } from './details/details.component';
import { EtudiantComponent } from './etudiant.component';
import { HomeComponent } from './home/home.component';
import { UpdateComponent } from './update/update.component';

const routes: Routes = [ { path: '', component: EtudiantComponent , children: [
  { path:'home', component: HomeComponent },
  { path:'add', component: CreateComponent },
  { path:'update/:idEtudiant', component: UpdateComponent },
  { path:'details/:idEtudiant', component: DetailsComponent }
  ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })],
  exports: [RouterModule]
})
export class EtudiantRoutingModule { }
