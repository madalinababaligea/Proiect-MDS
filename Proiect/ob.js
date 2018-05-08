class Persoana
{
	constructor(nume,parola,email)
	{
		this.name=nume;
		this.password=parola;
		this.email=email;
	}
	get_name(){return this.name;}
	get_parola(){return this.parola;}
	get_email(){return this.email;}
}