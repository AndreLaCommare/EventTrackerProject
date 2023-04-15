export class Gym {
  id: number;
  name: string;
  address: string;
  state: string;
  city: string;
  phoneNumber: string;
  imageUrl: string;

    constructor(
      id : number = 0,
      name: string = '',
      address: string = '',
      state: string = '',
      city: string = '',
      phoneNumber= '',
      imageUrl: string = ''

    ){
      this.id = id;
      this.name= name;
      this.address = address;
      this.state = state;
      this.city = city;
      this.phoneNumber = phoneNumber;
      this.imageUrl = imageUrl;
    }


}
