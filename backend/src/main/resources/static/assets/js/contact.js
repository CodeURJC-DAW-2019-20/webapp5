
    function initMap() {
      //Location of LCDD
      var lcdd = { lat: 40.335270, lng: -3.877363 }
      //Setup of map
      var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 16,
        center: lcdd,
        /*mapTypeId: 'hybrid',*/
        mapTypeControl: true,
        mapTypeControlOptions: {
          style: google.maps.MapTypeControlStyle.HORIZONTAL_BAR,
          position: google.maps.ControlPosition.TOP_LEFT
        },
        zoomControl: true,
        zoomControlOptions: {
          position: google.maps.ControlPosition.RIGHT_BOTTOM
        },
        streetViewControl: false,
        rotateControl: false
      });
      //Setup of marker
      var marker = new google.maps.Marker({
        position: lcdd,
        map: map,
        animation: google.maps.Animation.DROP,
        icon: './assets/img/otros/geo_icon.png'
      });

      var infowindow = new google.maps.InfoWindow({
        content: "S.008 Laboratorios II URJC</br>Calle Tulipán, s/n</br>28933 Móstoles, Madrid"
      });
      marker.addListener('click', function () {
        infowindow.open(map, marker);
      });

    }


  


    window.addEventListener("DOMContentLoaded", function () {
      // get the form elements defined in your form HTML above
      var form = document.getElementById("contact-form");
      var button = document.getElementById("contact-form-button");
      var status = document.getElementById("contact-form-status");
      // Success and Error functions for after the form is submitted
      function success() {
        form.reset();
        button.style = "display: none ";
        status.innerHTML = "Thanks!";
      }
      function error() {
        status.innerHTML = "Oops! There was a problem.";
      }
      // handle the form submission event
      form.addEventListener("submit", function (ev) {
        ev.preventDefault();
        var data = new FormData(form);
        ajax(form.method, form.action, data, success, error);
      });
    });
    // helper function for sending an AJAX request
    function ajax(method, url, data, success, error) {
      var xhr = new XMLHttpRequest();
      xhr.open(method, url);
      xhr.setRequestHeader("Accept", "application/json");
      xhr.onreadystatechange = function () {
        if (xhr.readyState !== XMLHttpRequest.DONE) return;
        if (xhr.status === 200) {
          success(xhr.response, xhr.responseType);
        } else {
          error(xhr.status, xhr.response, xhr.responseType);
        }
      };
      xhr.send(data);
    }
