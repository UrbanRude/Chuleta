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
	
	
## CONBINACION DE TECLAS
ALT+INS // PARA INSERTAR METODO 
