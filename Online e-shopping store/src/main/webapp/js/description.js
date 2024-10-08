function checkDescription(event) {
	
           var description = document.getElementById("description").value;

           // Check if description length exceeds 5000 characters
           if (description.length > 5) {
               alert('Description length has exceeded 5000 characters. Please enter a valid description.');
               event.preventDefault(); // Prevent form submission
               return false;
           }
		   else{
			return true; // Allow form submission
		   }
           
       }