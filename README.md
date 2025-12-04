# bastketbal
# bastketball
# 🏀 Basketball Score App

Aplicación Android para gestionar el marcador de un partido de baloncesto. Proyecto del primer trimestre usando Views, Layouts, Intents y Data Binding.

---

## 📌 Descripción

Aplicación móvil para llevar el marcador de un partido de baloncesto en tiempo real. Incluye dos pantallas:

- **MainActivity**: Pantalla principal con botones para sumar y restar puntos.  
- **ScoreActivity**: Pantalla que muestra el resultado final y quién ganó.

---

## 🚀 Funcionalidades

### MainActivity
- Marcadores para equipos **Local** y **Visitante**.  
- Botones **+1** y **+2** (verde).  
- Botón **-1** (rojo), no permite negativos.  
- Botón **Reset** para volver a 0.  
- Botón para ver resultados finales.  
- Compatible con **vertical y horizontal**.

### ScoreActivity
- Muestra el marcador final en formato `X - Y`.  
- Indica quién ganó o si fue empate.  
- Botón para volver al inicio.  
- Diseño adaptado a ambas orientaciones.

---

## 🛠️ Tecnologías
- **Kotlin 2.2.0**  
- **Data Binding** (sin `findViewById`)  
- **ConstraintLayout**  
- **CardView**  
- **Explicit Intents**  
- **Vector Drawables**  
- Strings en `strings.xml`

---

## 📁 Estructura del Proyecto
app/
├── src/main/
│ ├── java/com/example/basketball/
│ │ ├── MainActivity.kt
│ │ ├── ScoreActivity.kt
│ │ └── Constants.kt
│ ├── res/
│ │ ├── layout/
│ │ │ ├── activity_main.xml
│ │ │ └── activity_score.xml
│ │ ├── layout-land/
│ │ │ ├── activity_main.xml
│ │ │ └── activity_score.xml
│ │ ├── drawable/
│ │ │ ├── ic_basketball.xml
│ │ │ ├── ic_reset.xml
│ │ │ ├── ic_arrow_forward.xml
│ │ │ ├── button_score_positive.xml
│ │ │ ├── button_score_negative.xml
│ │ │ ├── button_background_gradient.xml
│ │ │ ├── score_background_premium.xml
│ │ │ ├── background_gradient.xml
│ │ │ └── message_background.xml
│ │ └── values/
│ │ ├── strings.xml
│ │ ├── colors.xml
│ │ └── themes.xml
└── AndroidManifest.xml


---

## ⚙️ Implementación Data Binding

**build.gradle.kts:**
```kotlin
buildFeatures { 
    dataBinding = true 
}


Uso en la Activity:

binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
binding.textViewLocalScore.text = localScore.toString()


Paso de Datos entre Activities

// Enviar
val intent = Intent(this, ScoreActivity::class.java)
intent.putExtra(Constants.EXTRA_LOCAL_SCORE, localScore)
intent.putExtra(Constants.EXTRA_VISITOR_SCORE, visitorScore)
startActivity(intent)

// Recibir
val localScore = intent.getIntExtra(Constants.EXTRA_LOCAL_SCORE, 0)
val visitorScore = intent.getIntExtra(Constants.EXTRA_VISITOR_SCORE, 0)


Rotación de Pantalla (Guardar Estado)

override fun onSaveInstanceState(outState: Bundle) {
    super.onSaveInstanceState(outState)
    outState.putInt("localScore", localScore)
    outState.putInt("visitorScore", visitorScore)
}


Validación (No permitir negativos)

if (localScore > 0) {
    localScore--
}


🎨 Diseño

CardViews con bordes redondeados y sombras

Botones con gradientes

Fondo con gradiente

Colores: Azul (Local), Rojo (Visitante), Verde (+), Naranja (general)

Marcadores grandes y centrados

Layouts separados para vertical y horizontal

## 📷 Imágenes

## Imagen 1
![Balón 1](imagenes/basketba.png)

## Imagen 2
![Balón 2](imagenes/basketbol.png)

## Imagen 3
![Balón 3](imagenes/basket.png)


⚠️ Errores Encontrados y Soluciones

android:strokeLinecap not found → Eliminar atributo y usar fillColor transparente

Incompatibilidad de versiones Kotlin → Usar kotlin = "2.2.0"

Archivos Compose causando errores → Eliminar archivos y quitar Compose del Gradle

Crash al abrir ScoreActivity (CardView anidado) → Simplificación del layout

Tema no disponible → Usar <style name="Theme.Basketball" parent="Theme.AppCompat.Light.NoActionBar" />

Marcadores se reinician al rotar → Implementar onSaveInstanceState + restauración

🔧 Posibles Errores Futuros

“Cannot resolve symbol 'R'” → Clean Project / Rebuild / Sync Gradle

Data Binding no genera clases → Verificar dataBinding = true

Crash al abrir ScoreActivity → Revisar drawables, evitar CardViews anidados

📦 Dependencias principales
implementation 'androidx.appcompat:appcompat:1.6.1'
implementation 'com.google.android.material:material:1.11.0'
implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
implementation 'androidx.cardview:cardview:1.0.0'

📄 Versiones

Kotlin: 2.2.0

Compile SDK: 36

Min SDK: 24

▶️ Instalación

Abrir proyecto en Android Studio

Sincronizar Gradle

Ejecutar en dispositivo o emulador
