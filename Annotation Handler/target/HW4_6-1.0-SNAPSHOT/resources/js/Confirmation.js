/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function showConfirmation() {
    var selectedItems = ''; // Initialize variable to store selected items
    var checkboxes = document.querySelectorAll('input[name=\"selectedItems\"]:checked');
    checkboxes.forEach(function (checkbox) {
        selectedItems += checkbox.value + '\n'; // Add selected item to the list
    });
    if (selectedItems !== '') {
        var result = confirm('Do you want to add the following items to your cart?\n' + selectedItems);
        if (result) {   // If user clicks 'Yes'
            document.forms[0].submit(); // Submit the form
        }
    }
}


function showRemoveConfirmation() {
    var result = confirm('Do you want to remove the selected items from your cart?');
    if (!result) {
        event.preventDefault(); // Prevent form submission
    }
}

function updateCheckedItems(checkbox) {
        var checkedItems = document.getElementById("selectedItems");
        if (checkbox.checked) {
                checkedItems.value += checkbox.value + ",";
        } else {
            checkedItems.value = checkedItems.value.replace(checkbox.value + ",", "");
        }
    }