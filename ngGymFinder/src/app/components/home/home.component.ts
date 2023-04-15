import { Component } from '@angular/core';
import { Gym } from 'src/app/models/gym';
import { GymService } from 'src/app/services/gym.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  gyms: Gym[] = [];
constructor (
  private gymService : GymService
){}

ngOnInit(): void{
  this.reload();
}

reload(){
  this.gymService.index().subscribe({
    next: (data) =>{
      this.gyms = data;
    },
    error: (fail) => {
      console.log("error loading gyms: " + fail);

    }
  })
}

newGym: Gym = new Gym();
selected: Gym | null = null;
editGym: Gym | null = null;


displayGym(gym: Gym){
  this.selected = gym;
}

displayTable(){
  this.selected = null;
}


addGym(newGym: Gym){
  console.log(newGym);
  this.gymService.create(newGym).subscribe( {
    next:(createdGym) => {
      this.reload();
    },
    error:(ohno) => {
      console.error("on no")

    }
  });


}

setEditGym(){
  this.editGym = Object.assign({}, this.selected)
}



updateGym (gym: Gym, goToDetail = true){
  console.log(gym);
  this.gymService.update(gym).subscribe({
    next:(updatedGym) => {
      this.editGym = null;
      if(goToDetail){
        this.selected = updatedGym;

      }
      this.reload();
      // this.todos = this.todoServ.index();

    },
    error: (fail) => {
      console.error("Error updating todo");
      console.error(fail);
    }
  })
}


deleteGym(gymId: number){
  this.gymService.destroy(gymId);
  this.gymService.destroy(gymId).subscribe({
    next:()=>{
      this.reload()
    },
    error:(fail)=>{
      console.error(fail);
      console.error("ERROR DELETING");
    }
  })
  // this.todos = this.todoServ.index();
}
}
