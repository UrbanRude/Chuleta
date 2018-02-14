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

## CARGAR UN ARRAY EN UN LISTVIEW
// FORMA PARA CARGAR EL ARREGLO A UNA VARIABLE
String[] titulos = getResources().getStringArray(R.array.materias);
ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,titulos);
horario = (ListView)findViewById(R.id.lista);
horario.setAdapter(adapter);

// FORMA PARA CARGAR DIRECTAMENTE EL ARREGLO
ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.dias_semana,android.R.layout.simple_list_item_1);
horario = (ListView)findViewById(R.id.lista);
horario.setAdapter(adapter);

# LISTVIEW CON ADAPTER PERSONALIZADO
#-----------------------------------------------------------------------------------------------
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical" android:layout_width="match_parent"
    android:layout_height="match_parent">
    <TextView
        android:id="@+id/titulo"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textAppearance="?android:textAppearanceLarge"/>
    <TextView
        android:id="@+id/subtitulo"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textStyle="italic" />
</LinearLayout>

public class DiaHorario {
    private String asignatura;
    private  String dia;
    public DiaHorario(String asignatura, String dia) {
        this.asignatura = asignatura;
        this.dia = dia;
    }
    public String getAsignatura() {
        return asignatura;
    }
    public String getDia() {
        return dia;
    }
    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }
    public void setDia(String dia) {
        this.dia = dia;
    }
}

public class DiaHorarioAdapter extends ArrayAdapter<DiaHorario>{

    public DiaHorarioAdapter(@NonNull Context context,List<DiaHorario> objetos) {
        super(context, R.layout.list_template,objetos);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.list_template,null);

        TextView titulo = (TextView) item.findViewById(R.id.titulo);
        TextView subtitulo = (TextView) item.findViewById(R.id.subtitulo);

        titulo.setText(getItem(position).getAsignatura());
        subtitulo.setText(getItem(position).getDia());

        return item;
    }
}

public class MainActivity extends AppCompatActivity {

    private ListView horario;
    private ArrayList<DiaHorario> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] titulos = getResources().getStringArray(R.array.materias);
        String[] subtitulos = getResources().getStringArray(R.array.dias_semana);
        lista = new ArrayList<>();
        for (int i=0;i<titulos.length;i++){
            lista.add(new DiaHorario(titulos[i],subtitulos[i]));
        }
        DiaHorarioAdapter adapter = new DiaHorarioAdapter(this,lista);
        horario = (ListView)findViewById(R.id.lista);
        horario.setAdapter(adapter);
    }
}

## EJEMPLO DE LISTVIEW PERZONALIZADO CON EVENTO SWITCH
public class AlarmaAdapter extends ArrayAdapter<Alarma> {
    public AlarmaAdapter(@NonNull Context context, List<Alarma> objetos){
        super(context, R.layout.alarma_template,objetos);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = convertView;
        if (convertView == null){
            view = inflater.inflate(R.layout.alarma_template,null);
        }
        //Definicion de objetos de la interfaz grafica
        TextView hora = (TextView) view.findViewById(R.id.hora);
        final TextView activo = (TextView) view.findViewById(R.id.activo);
        Switch btnActivo = (Switch) view.findViewById(R.id.btnActivo);
        //Asignación de valores
        hora.setText(getItem(position).getHora());
        if (getItem(position).isActivo())activo.setText("Activado");
        else activo.setText("Desactivado");
        btnActivo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    activo.setText("Activado");
                    getItem(position).setActivo(isChecked);
                }else {
                    activo.setText("Desactivado");
                    getItem(position).setActivo(isChecked);
                }
            }
        });

        return view;
    }
}
#-----------------------------------------------------------------------------------------------

## CONBINACION DE TECLAS
ALT+INS // PARA INSERTAR METODO 
