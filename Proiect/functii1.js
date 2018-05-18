//$('.message a').click(function(){
//$('form').animate({height: "toggle", opacity: "toggle"}, "slow");});
window.onload=function()
{
   var a1=document.querySelector('.register-form .message a');
   var log=document.querySelector('.login-form');
   var reg=document.querySelector('.register-form');
   var persoane=[];
   a1.onclick=function()
   {
	   log.style.display='inline';
	   reg.style.display='none';
   }
   var a2=document.querySelector('.login-form .message a');
   a2.onclick=function()
   {
	   reg.style.display='inline';
	   log.style.display='none';
   }
   var but1=document.getElementById("reg");
   var but2=document.getElementById("log");
   var name=document.getElementById("name");
   var pass=document.getElementById("pass");
   var conf=document.getElementById("conf");
   var email=document.getElementById("email");
   var nume=document.getElementById("nume");
   var prenume=document.getElementById("prenume");
   var adresa=document.getElementById("adresa");
   var c=document.getElementById('c');
   var m=document.getElementById('m');
   but1.onclick=function()
   {
	   /*if(name.value=="" || pass.value=="" || conf.value=="" || email.value=="" ||(c.checked==false && m.checked==false))// || nume.value=="" || prenume.value=="" || adresa.value=="")
		   alert("Nu ai introdus datele");
	   else
			if(name.value.length<6)
			   alert("Username prea scurt");
		    else
			    if(pass.value!=conf.value)
					alert("Parolele difera");
				else
					if(pass.value.length<6)
						alert("Parola prea scurta");
					else
						if(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email.value)==false)
							alert("Email-ul nu este corect");
						else*/
						{
							var pers=JSON.parse(localStorage.getItem('persoana'));
							var gasit=false;
							if(pers==null)
								gasit=false;
							else
							{
								for(var i=0;i<pers.length && gasit==false;i++)
								{
									if(name.value==pers[i].name)
									{
										alert("Exista deja un utilizator cu acest nume");
										gasit=true;
									}
									if(email.value==pers[i].email)
									{
										alert("Exista deja un utilizator cu acest email");
										gasit=true;
									}
								}
							}
							if(gasit==false)
							{
								var util;
								if(c.checked==true)
									util=c.value;
								else
									util=m.value;
								pers.push({name:name.value,
												password: pass.value,
												email: email.value,
												utilizator:util,
												prenume: prenume.value,
												nume: nume.value,
												adresa: adresa.value});
								localStorage.setItem('persoana',JSON.stringify(persoane));
								log.style.display='inline';
								reg.style.display='none';
							}
						}
		//var pers=JSON.parse(localStorage.getItem('persoana')); // informatiile pentru fiecare persoana
	}
   var user=document.getElementById("user");
   var pas=document.getElementById("pas");
   var pag=document.getElementById("login-page");
   but2.onclick=function()
   {
	   var tip,utilizat,numeU,prenumeU;
	   if(user.value=="" || pas.value=="")
		   alert("Nu ai introdus username-ul sau parola");
	   else
	   {
		   var pers=JSON.parse(localStorage.getItem('persoana'));
		   var gasit=false;
		   if(pers==null)
			   gasit=false;
		   else
		   {
			   for(var i=0;i<pers.length && gasit==false;i++)
			   {
					if(user.value==pers[i].name)
						if(pas.value==pers[i].password)
						{
							gasit=true;
							tip=pers[i].utilizator;
							utilizat=pers[i].name;
							numeU=pers[i].nume;
							prenumeU=pers[i].prenume;
							localStorage.setItem("userConectat",utilizat);
							localStorage.setItem("tipConectat",tip);
						}
				}
		   }
		   if(gasit==false)
			   alert("Nu exista utilizator cu aceste date");
		   else
		   {
			   pag.style.display='none';
			   var h=document.querySelector('h1');
			   var b=document.querySelector('h1 b');
			   h.style.display="inline";
			   b.innerText=numeU+" "+prenumeU+" ("+tip+")";
			   if(tip=="client")
			   {
				   var n=document.getElementById("client");
				   n.style.display="inline";
				   n.style.width="100%";
			   }
			   else
			   {
				   var n=document.getElementById("manager");
				   n.style.display="inline";
				   n.style.width="100%";
			   }
			   var p=document.getElementById("pagina");
			   p.style.display="block";
		   }
	   }
   }
   //localStorage.clear();
}

