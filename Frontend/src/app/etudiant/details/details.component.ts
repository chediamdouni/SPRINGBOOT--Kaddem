import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Etudiant } from 'src/app/models/etudiant';
import { EtudiantService } from 'src/app/service/etudiant.service';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent {
  etudiant: Etudiant
  id: number

  constructor(
    private etudiantService: EtudiantService,
    private route: Router, 
    private activatedRoute: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.etudiant = new Etudiant()
    this.id = parseInt(this.activatedRoute.snapshot.params["idEtudiant"])
    console.log(this.id)
    this.etudiantService.getEtudiantById(this.id).subscribe( data => {
      this.etudiant = data;
    })
  }

  returnHome(){
    this.route.navigateByUrl("/etudiant/home")
  }

  removeEtudiant(){
    this.etudiantService.deleteEtudiant(this.etudiant.idEtudiant).subscribe(res => {
      console.log("Etudiant Deleted")
      this.returnHome()
    })
  }

}
