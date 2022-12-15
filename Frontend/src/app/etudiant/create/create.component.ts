import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Etudiant } from 'src/app/models/etudiant';
import { EtudiantService } from 'src/app/service/etudiant.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit{
  
  etudiant: Etudiant


  constructor(
    private etudiantService: EtudiantService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.etudiant = new Etudiant()
  }

  addEtudiant(){
    this.etudiantService.addEtudiant(this.etudiant).subscribe( res => {
      console.log("Etudiant Added")
      this.router.navigateByUrl("/etudiant/home")
    })
  }

}
