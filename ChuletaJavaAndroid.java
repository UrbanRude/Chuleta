## CAMBIAR DE ACTIVITY				
Intent intent = new Intent(this, // Actividad en la que estamos
					ActividadCambiar); // Actividad a la que nos vamos a dirigir
startActivity(intent);

## CREAR UN EVENTO DE CLICK
public void ClickBoton(View view){
	// OBTENER UN STRING DE LOS RECURSOS values/strings
	String cadena = getString(R.string.cadena);
	elemento.setText(cadena);
}

## ENVIAR DATOS DE UNA ACTIVIDAD A OTRA CON EL METODO INTENT
Intent intent = new Intent(this, // Avtividad en la que estamos
					ActividadCambiar); // Actividad a la que nos vamos a dirigir
// El metodo putExtra recibe dos elementos
intent.putExtra("NombreLlave", //Nombre de como lo vamos a recibir
				VariableEnviar); //Variable a Enviar de tipo String
startActivity(intent);

## CLICO DE VIDA DE UN ACTIVITY
@Override
    protected void onStart() {
        super.onStart();
        Log.wtf("Ciclo de Vida","onStart");
    }

@Override
    protected void onRestart() {
        super.onRestart();
        Log.wtf("Ciclo de Vida","onRestart");
    }

@Override
    protected void onResume() {
        super.onResume();
        Log.wtf("Ciclo de Vida","onResume");
    }

@Override
    protected void onPause() {
        super.onPause();
        Log.wtf("Ciclo de Vida","onPause");
    }

@Override
    protected void onStop() {
        super.onStop();
        Log.wtf("Ciclo de Vida","onStop");
    }

@Override
    protected void onDestroy() {
        super.onDestroy();
        Log.wtf("Ciclo de Vida","onDestroy");
    }

	
## GUARDAR UN ESTADO DE UN ACTIVITY
private static final String STATE_MENSAJE = "estado_mensaje";
@Override
protected void onSaveInstanceState(Bundle outState) {
	super.onSaveInstanceState(outState);
	outState.putString(STATE_MENSAJE, //  RECIBE UNA LLAVE DE TIPO STRING
	elemento.getText().toString());
}

@Override
protected void onRestoreInstanceState(Bundle savedInstanceState) {
	super.onRestoreInstanceState(savedInstanceState);
	elemento.setText(savedInstanceState.getString(STATE_MENSAJE));
}

## CREAR UN ARRAY EN STRING.XML
<string-array name="NombreArray"> //Etiqueta array
	<item>Matematicas</item> //elementos
	<item>Ciencias naturales</item>
	<item>Ciencias Sociales</item>
	<item>Lengua castellana</item>
	<item>Fisica</item>
	<item>Quimica</item>
</string-array>

## CARGAR UN ARRAY EN UN LISVIEW
// FORMA PARA CARGAR EL ARREGLO A UNA VARIABLE
String[] titulos = getResources().getStringArray(R.array.materias);
ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,titulos);
horario = (ListView)findViewById(R.id.lista);
horario.setAdapter(adapter);

// FORMA PARA CARGAR DIRECTAMENTE EL ARREGLO
ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.dias_semana,android.R.layout.simple_list_item_1);
horario = (ListView)findViewById(R.id.lista);
horario.setAdapter(adapter);

## CONBINACION DE TECLAS
ALT+INS // PARA INSERTAR METODO 
