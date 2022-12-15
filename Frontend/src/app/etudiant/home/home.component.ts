import { Component, OnInit } from '@angular/core';
import { Etudiant } from 'src/app/models/etudiant';
import { EtudiantService } from 'src/app/service/etudiant.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{
  etudiant: Etudiant[];

  constructor(
    private etudiantService: EtudiantService,
  ) { }

  ngOnInit(): void {
    this.etudiantService.getAllEtudiant().subscribe( data => {
      this.etudiant = data;
      console.log(this.etudiant)
    })
  }

  removeEtudiant(en: Etudiant){
    let i = this.etudiant.indexOf(en)
    if(i!=-1) this.etudiant.splice(i,1)
    this.etudiantService.deleteEtudiant(en.idEtudiant).subscribe( res => {
      console.log("etudiant deleted")
    })
  }
}
