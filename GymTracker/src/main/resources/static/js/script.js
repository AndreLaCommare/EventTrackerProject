window.addEventListener('load', function(evt) {



	init();
})


function init() {

	loadAllGyms();

	document.gymForm.lookup.addEventListener('click', function(event) {
		event.preventDefault();
		let gymId = document.gymForm.gymId.value;
		if (!isNaN(gymId) && gymId > 0) {
			getGym(gymId);
		}
	});

	//document.getElementById('seeGymBtn').addEventListener('click', function(event) {

	//let gymId = document.gymForm.gymId.value;
	//if (!isNaN(gymId) && gymId > 0) {
	//	getGym(gymId);
	//}
	//});

	document.createGymForm.createGymBtn.addEventListener('click', function(event) {
		event.preventDefault();

		createGym();
		loadAllGyms();

	});
}





function loadAllGyms() {

	//XHR stuff
	let xhr = new XMLHttpRequest();

	xhr.open('GET', 'api/gyms');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {

			if (xhr.status === 200) {

				let gymList = JSON.parse(xhr.responseText);
				displayGymList(gymList);
			}

		}

	}
	xhr.send();

}

function displayGymList(gyms) {
	let tbody = document.getElementById("GymListTBody");
	tbody.textContent = '';
	for (let gym of gyms) {
		if (gym != null) {

			let tr = document.createElement('tr');
			tr.id = gym.id;

			tr.addEventListener('click', function(e) {
				e.preventDefault();
				let gymId = e.target.parentElement.firstElementChild.textContent;

				getGym(gymId);

			});

			let td = document.createElement('td');
			td.textContent = gym.id;
			tr.appendChild(td);

			td = document.createElement('td');
			td.textContent = gym.name;
			tr.appendChild(td);

			tbody.appendChild(tr);

		}


	}
	//DOM stuff

}


function displayError() {
	document.getElementById('gymData').textContent = 'Gym not Found';
}


function getGym(gymId) {

	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/gyms/' + gymId)
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				let gymJson = xhr.responseText;
				let gym = JSON.parse(gymJson);
				displayGym(gym)
			} else {
				displayError();
			}
		}
	};

	xhr.send();
}

function displayGym(gym) {

	let dataDiv = document.getElementById('gymData');
	dataDiv.textContent = '';
	// TODO:
	// * Create and append elements to the data div to display:
	// * Film title (h1) and description (blockquote).
	let h1 = document.createElement('h1')
	h1.textContent = gym.name;
	dataDiv.appendChild(h1);

	let block = document.createElement('blockquote')
	block.textContent = gym.address;
	dataDiv.appendChild(block);

	let ul = document.createElement('ul');
	let li1 = document.createElement('li');
	let li2 = document.createElement('li');
	let li3 = document.createElement('li');

	li1.textContent = gym.phoneNumber;
	li2.textContent = gym.city;
	li3.textContent = gym.state;
	ul.appendChild(li1);
	ul.appendChild(li2);
	ul.appendChild(li3);
	dataDiv.appendChild(ul);

	document.getElementById('newGymForm').style.display = 'none';
	
	

	let updateBtn = document.createElement('button');
	let deleteBtn = document.createElement('button');

	updateBtn.textContent = "Update Gym";
	deleteBtn.textContent = "Delete Gym";
	
	updateBtn.addEventListener('click', function(e){
		e.preventDefault();
		updateBtn.hidden = "hidden";
		document.getElementById('updateForm').hidden = '';
	})


	//<label for="gymName">Name: </label><input type="text" id="updateGymName"  required><br><br>
	//<label for="gymAddress">Address: </label><input type="text" id="updateGymAddress" ><br><br>
	//<label for="gymPhone">Phone Number: </label><input type="text" id="updateGymPhone" ><br><br>
	//<label for="gymState">State: </label><input type="text" id="updateGymState" ><br><br>
	//<label for="gymCity">City: </label><input type="text" id="updateGymCity" ><br><br>


		document.getElementById('updateGymName').value = gym.name;
		document.getElementById('updateGymAddress').value = gym.address;
		document.getElementById('updateGymPhone').value = gym.phoneNumber;
		document.getElementById('updateGymState').value = gym.state;
		document.getElementById('updateGymCity').value = gym.city;

		document.getElementById('updateGymBtn').addEventListener('click', function(evt) {
		evt.preventDefault();
		let xhr = new XMLHttpRequest();
		
		
		
		
		let gymObject = {

			name: document.getElementById('updateGymName').value,
			address: document.getElementById('updateGymAddress').value,
			phoneNumber: document.getElementById('updateGymPhone').value,
			state: document.getElementById('updateGymState').value,
			city: document.getElementById('updateGymCity').value
		};
		


		
		xhr.open('PUT', 'api/gyms/' + gym.id);
		xhr.setRequestHeader("Content-type", "application/json");
		xhr.onreadystatechange = function() {
			if (xhr.readyState === 4) {
				if (xhr.status === 200 || xhr.status === 201) {

					let data = JSON.parse(xhr.responseText);
					console.log(data);
					//displayGym(data);
				}
				else {
					console.error("PUT request failed.");
					console.error(xhr.status + ': ' + xhr.responseText);
				}
			}
		}
		let gymObjectJson = JSON.stringify(gymObject);


		xhr.send(gymObjectJson);
		window.location.reload();
	})

	deleteBtn.addEventListener('click', function(evt) {
		evt.preventDefault();
		let xhr = new XMLHttpRequest();
		xhr.open('DELETE', 'api/gyms/' + gym.id);
		xhr.onreadystatechange = function() {
			if (xhr.readyState === 4) {
				if (xhr.status === 200 || xhr.status === 204) {
					//let data = JSON.parse(xhr.responseText);
					//console.log(data);
					window.location.reload();
					loadAllGyms();
					//displayGym(data);
				}
				else {
					console.error("DELETE request failed.");
					console.error(xhr.status + ': ' + xhr.responseText);
				}
			}
		}

		xhr.send();
	})

	dataDiv.appendChild(updateBtn);
	dataDiv.appendChild(deleteBtn);


}


function createGym() {
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'api/gyms', true);
	xhr.setRequestHeader("Content-type", "application/json");

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200 || xhr.status === 201) { // Ok or Created
				let data = JSON.parse(xhr.responseText);
				console.log(data);
				//displayGym(data);
			}
			else {
				console.error("POST request failed.");
				console.error(xhr.status + ': ' + xhr.responseText);
			}
		}
	};

	let gymObject = {
		name: document.getElementById('newGymName').value,
		address: document.getElementById('newGymAddress').value,
		phoneNumber: document.getElementById('newGymPhone').value,
		state: document.getElementById('newGymState').value,
		city: document.getElementById('newGymCity').value
	};

	let gymObjectJson = JSON.stringify(gymObject);


	xhr.send(gymObjectJson);
	window.location.reload();

}

