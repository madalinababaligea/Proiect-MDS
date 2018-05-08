window.onload=function()
{
	var tip=localStorage.getItem("tipConectat");
	if(tip=="client")
	{
		document.getElementById("client").style.display="inline";
		document.getElementById("client").style.width="100%";
	}
	else
	{
		document.getElementById("manager").style.display="inline";
		document.getElementById("manager").style.width="100%";
	}
	 var pers=JSON.parse(localStorage.getItem('persoana'));
	 var gasit=false;
	 var user=localStorage.getItem("userConectat");
	 for(var i=0;i<pers.length && gasit==false;i++)
	 {
		if(pers[i].name==user)
		{
			gasit=true;
			var div=document.getElementById("pagina");
			var titlu=document.createElement("H1");
			titlu.innerText="Profil";
			div.appendChild(titlu);
			var numeL=document.createTextNode("Nume:");
			div.appendChild(numeL);
			var span=document.createElement("span");
			span.className="label";
			var numeU=document.createTextNode(pers[i].nume);
			span.appendChild(numeU);
			span.style.marginLeft="20px";
			div.appendChild(span);
			var a=document.createElement("a");
			a.innerText="Editeaza";
			a.onclick=function(event){
										event.preventDefault();
										if(a.innerText=="Salveaza")
										{
											a.innerText="Editeaza"
											span.contentEditable="false";
										}
										else
										{
											span.contentEditable="true";
											a.innerText="Salveaza";
										}
									}
			a.href="#";
			div.appendChild(a);
			div.appendChild(document.createElement("BR"));
			var prenumeL=document.createTextNode("Prenume:");
			div.appendChild(prenumeL);
			var span1=document.createElement("span");
			span1.className="label";
			var prenumeU=document.createTextNode(pers[i].prenume);
			span1.appendChild(prenumeU);
			span1.style.marginLeft="20px";
			div.appendChild(span1);
			var a1=document.createElement("a");
			a1.innerText="Editeaza";
			a1.onclick=function(event){
										event.preventDefault();
										if(a1.innerText=="Salveaza")
										{
											a1.innerText="Editeaza"
											span.contentEditable="false";
										}
										else
										{
											span.contentEditable="true";
											a1.innerText="Salveaza";
										}
									}
			a1.href="#";
			div.appendChild(a1);
			div.appendChild(document.createElement("BR"));
			var adresaL=document.createTextNode("Adresa:");
			div.appendChild(adresaL);
			var span2=document.createElement("span");
			span2.className="label";
			var adresaU=document.createTextNode(pers[i].adresa);
			span2.appendChild(adresaU);
			span2.style.marginLeft="20px";
			div.appendChild(span2);
			var a2=document.createElement("a");
			a2.innerText="Editeaza";
			a2.onclick=function(event){
										event.preventDefault();
										if(a2.innerText=="Salveaza")
										{
											a2.innerText="Editeaza"
											span.contentEditable="false";
										}
										else
										{
											span.contentEditable="true";
											a2.innerText="Salveaza";
										}
									}
			a2.href="#";
			div.appendChild(a2);
			div.appendChild(document.createElement("BR"));
			var emailL=document.createTextNode("Email:");
			div.appendChild(emailL);
			var span3=document.createElement("span");
			span3.className="label";
			var emailU=document.createTextNode(pers[i].email);
			span3.appendChild(emailU);
			span3.style.marginLeft="20px";
			div.appendChild(span3);
			var a3=document.createElement("a");
			a3.innerText="Editeaza";
			a3.onclick=function(event){
										event.preventDefault();
										if(a3.innerText=="Salveaza")
										{
											a3.innerText="Editeaza"
											span.contentEditable="false";
										}
										else
										{
											span.contentEditable="true";
											a3.innerText="Salveaza";
										}
									}
			a3.href="#";
			div.appendChild(a3);
			div.appendChild(document.createElement("BR"));
			var tipL=document.createTextNode("Tip utilizator:");
			div.appendChild(tipL);
			var span4=document.createElement("span");
			span4.className="label";
			var tipU=document.createTextNode(pers[i].utilizator);
			span4.appendChild(tipU);
			span4.style.marginLeft="20px";
			div.appendChild(span4);
			
		}
	 }
}