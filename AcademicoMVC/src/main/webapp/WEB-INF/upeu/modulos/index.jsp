
    <script>
    $( function() {
      $( ".widget input[type=submit], .widget a, .widget button" ).button();
      $( "button, input, a" ).click( function( event ) {
        event.preventDefault();
      } );
    } );
    </script>        
    <h1>Hello World! MVC DMP</h1>
    <br/>
    <a href="/pers" class="btn btn-warning">Ir Persona</a>

    <button class="ui-button ui-widget ui-corner-all">A button element</button>

    <input class="ui-button ui-widget ui-corner-all" type="submit" value="A submit button">

    <a class="ui-button ui-widget ui-corner-all" href="#">An anchor</a>  
        
  <button class="btn waves-effect waves-light" type="submit" name="action">Submit
    <i class="material-icons right">send</i>
  </button>        
