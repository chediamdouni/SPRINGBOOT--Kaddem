import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Etudiant } from 'src/app/models/etudiant';
import { EtudiantService } from 'src/app/service/etudiant.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit{
  
  etudiant: Etudiant
  id: number 

  constructor(
    private etudiantService: EtudiantService,
    private router: Router, 
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

  updateEtudiant(){
    this.etudiantService.updateEtudiant(this.etudiant.idEtudiant, this.etudiant).subscribe(
      res => {
        console.log("Etudiant Updated")
        this.router.navigateByUrl("/etudiant/home")
      }
    )
  }

}
