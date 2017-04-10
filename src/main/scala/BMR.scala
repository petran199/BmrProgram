import javafx.beans.value.{ChangeListener, ObservableValue}
import scalafx.application
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.control._
import scalafx.scene.layout.{BorderPane, GridPane}
import scalafx.geometry.Insets
import scalafx.Includes._
import scalafx.scene.paint.Color
import scalafx.event.ActionEvent
import scalafx.scene.text.Font

class BMR {

}
object BMImain extends JFXApp{

  stage = new application.JFXApp.PrimaryStage{
    title="BMR App"
    scene = new Scene(640,360){
      val menuBar= new MenuBar
      val fileMenu= new Menu("File")
      val exitItem= new MenuItem("Exit")
      fileMenu.items= List(new SeparatorMenuItem(), exitItem)
      menuBar.menus= List(fileMenu)
      exitItem.onAction = (e: ActionEvent) => {sys.exit(0)}

      val tfAge= new TextField()
      val tfHeight= new TextField()
      val tfWeight= new TextField()
      tfWeight.setId("tfWeight")
      val rbMale= new RadioButton("Male")
      rbMale.setId("rbMale")
      rbMale.selected = true
      rbMale.onAction = (e: ActionEvent) => {
        rbMale.selected = true
        rbFemale.selected = false
      }

      val rbFemale= new RadioButton("Female")
      rbFemale.setId("rbFemale")
      rbFemale.onAction =  (e: ActionEvent) => {
        rbMale.selected = false
        rbFemale.selected = true
      }
      val btnCalc = new Button("Calculate")
      btnCalc.setId("btnCalc")


      def calc(): Double = {
        if(rbMale.selected()) {
          val man = (10 * tfWeight.text.value.toInt) + (6.25 * tfHeight.text().toInt) - (5 * tfAge.text().toInt) + 5
          return man
        }else {
          val woman = (10 * tfWeight.text.value.toInt) + (6.25 * tfHeight.text().toInt) - (5 * tfAge.text().toInt )- 161
          return woman
        }
      }

      val lblAge = new Label("Age ")
      val lblHeight = new Label("Height")
      val lblWeight = new Label("Weight")
      val lblGender = new Label("Gender")
      val lblCm = new Label("Cm")
      val lblKg = new Label("Kg")
      val lblCalcInfo= new Label("")
      lblCalcInfo.setId("lblCalcInfo")

      val listItems= List(lblAge,tfAge,lblGender,rbMale,rbFemale,lblHeight,tfHeight,lblCm,lblWeight,tfWeight,lblKg,btnCalc,lblCalcInfo)

      val gridPane= new GridPane
      var row=0
      var col=0

      val margin= Insets(5.0,5.0,5.0,5.0)
      val pading= Insets(5.0,5.0,5.0,5.0)

      for (i <-0 to listItems.length -1  ){
        if ( col%2 ==0 && col!=0  && i==2) {
            row += 1
            col = 0
            gridPane.add(listItems(i),col,row)
            listItems(i).prefWidth=50
            listItems(i).margin=margin
            listItems(i).padding=pading
            col+=1
        }
        else if( col%3==0 && col != 0){
            row += 1
            col=0
          if(listItems(i).getId == "btnCalc"){gridPane.add(listItems(i),col,row,2,1)
            listItems(i).margin= Insets(20,10,10,10)
            listItems(i).padding=pading
            col += 1
          }
          else {
            gridPane.add(listItems(i), col, row)
            listItems(i).prefWidth = 50
            listItems(i).margin = margin
            listItems(i).padding = pading
            col += 1
          }
        }
        else{
            if(listItems(i).getId=="rbMale" || listItems(i).getId=="rbFemale"){
              gridPane.add(listItems(i),col,row)
              listItems(i).margin = margin
              listItems(i).padding = pading
              col+=1
            }else if(listItems(i).getId == "lblCalcInfo"){
              gridPane.add(listItems(i),col,row,2,1)
              lblCalcInfo.prefWidth =200
              //lblCalcInfo.prefHeight = 100
              val myFontSize = new Font(16)
              lblCalcInfo.font_=(myFontSize)
              lblCalcInfo.wrapText = true
              listItems(i).margin= Insets(20,10,10,20)
              listItems(i).padding=pading
              col+=1
            }else{
              gridPane.add(listItems(i),col,row)
              listItems(i).prefWidth = 50
              listItems(i).margin=margin
              listItems(i).padding=pading
              col+=1
            }
        }
      }

      tfAge.textProperty().addListener(new ChangeListener[String] {
        override def changed(observable: ObservableValue[_ <: String], oldValue: String, newValue: String): Unit = {
          if (!newValue.matches("\\d*")) {
            tfAge.setText(newValue.replaceAll("[^\\d]", "")) //[^\\d]", "
          }
          else{
            val newval= newValue.toCharArray
            if (newValue.length() > 2){
                val trash = newval.charAt(1)
                val trash2 = newval.charAt(2)
                newval(0) = trash
                newval(1) = trash2
                val newval2 = newval.subSequence(0, 2)
                tfAge.setText(newval2.toString)
            }
          }
        }

      })

      tfHeight.textProperty().addListener(new ChangeListener[String] {
        override def changed(observable: ObservableValue[_ <: String], oldValue: String, newValue: String): Unit = {
          if (!newValue.matches("\\d*")) {
            tfHeight.setText(newValue.replaceAll("[^\\d]", "")) //[^\\d]", "
          }
          else{
            val newval= newValue.toCharArray
            if (newValue.length() > 3){
              val trash = newval.charAt(1)
              val trash2 = newval.charAt(2)
              val trash3 = newval.charAt(3)
              newval(0) = trash
              newval(1) = trash2
              newval(2) = trash3
              val newval2 = newval.subSequence(0, 3)
              tfHeight.setText(newval2.toString)
            }
          }
        }

      })

      tfWeight.textProperty().addListener(new ChangeListener[String] {
        override def changed(observable: ObservableValue[_ <: String], oldValue: String, newValue: String): Unit = {
          if (!newValue.matches("\\d*")) {
            tfWeight.setText(newValue.replaceAll("[^\\d]", "")) //[^\\d]", "
          }
          else{
            val newval= newValue.toCharArray
            if (newValue.length() > 3){
              val trash = newval.charAt(1)
              val trash2 = newval.charAt(2)
              val trash3 = newval.charAt(3)
              newval(0) = trash
              newval(1) = trash2
              newval(2) = trash3
              val newval2 = newval.subSequence(0, 3)
              tfWeight.setText(newval2.toString)
            }
          }
        }

      })

      btnCalc.onAction = (e: ActionEvent) => {
        val calculation = calc().toInt
        lblCalcInfo.text= s"BMR = $calculation Cal/Day"
        lblCalcInfo.setTextFill(Color.Olive)
      }
      gridPane.margin= Insets(20,0,0,0)
      val rootPane= new BorderPane
      val bordPane = new BorderPane
      rootPane.top= menuBar
      rootPane.center=gridPane
      root= rootPane
    }
  }
}


