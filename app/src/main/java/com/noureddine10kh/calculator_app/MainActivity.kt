package com.noureddine10kh.calculator_app

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.noureddine10kh.calculator_app.databinding.ActivityMainBinding
import kotlin.math.*

class MainActivity : AppCompatActivity() {
    lateinit var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.getRoot())
    }

    /////////////////////////////////////////////////////////////////

    var char = '_'
    var oldNumber = 0.0
    private var dot = false
    private var result = 1.0
    private var sumNum :Double = 1.0
    private var sumSign: MutableList<Char> = mutableListOf()
    private var sumNumList: MutableList<Double> = mutableListOf()

    fun numberClicked(view: View) {
            val buSelect = view as Button
        if (binding.ShowNumber.text.toString().length==1 && binding.ShowNumber.text.toString().toInt()==0 ) {
            when (buSelect.id) {
                R.id.bu0 -> {
                    binding.ShowNumber.setText("0")
                }
                R.id.buDot -> {
                    binding.ShowNumber.setText("0.")
                }
                R.id.buPlusMinus -> {
                    binding.ShowNumber.setText("0")
                }
                R.id.inverseX -> {
                    binding.ShowNumber.setText("0")
                    Toast.makeText(this,"you must enter a number for use this option",Toast.LENGTH_LONG).show()
                }
                R.id.Xpow2 -> {
                    binding.ShowNumber.setText("0")
                    Toast.makeText(this,"you must enter a number for use this option",Toast.LENGTH_LONG).show()
                }
                R.id.XPow3 -> {
                    binding.ShowNumber.setText("0")
                    Toast.makeText(this,"you must enter a number for use this option",Toast.LENGTH_LONG).show()
                }
                R.id.LogBut->{
                    binding.ShowNumber.setText("0")
                }
                R.id.factBut->{
                    binding.ShowNumber.setText("0")
                    Toast.makeText(this, "enter a  number for use this option", Toast.LENGTH_LONG).show()
                }
                else->{
                binding.ShowNumber.setText("")
                }
            }
        }
            var buClickValue: String = binding.ShowNumber.text.toString()
             when(buSelect.id) {

                 R.id.bu0 -> {
                         buClickValue += "0"
                     if (!binding.deleteBut.isEnabled){
                         binding.deleteBut.isEnabled = true
                         binding.deleteBut.setBackgroundColor(ContextCompat.getColor(this,R.color.whiteback))
                     }
                 }

                 R.id.bu1 -> {
                     buClickValue += "1"
                     if (!binding.deleteBut.isEnabled){
                         binding.deleteBut.isEnabled = true
                         binding.deleteBut.setBackgroundColor(ContextCompat.getColor(this,R.color.whiteback))
                     }
                 }

                 R.id.bu2 -> {
                     buClickValue += "2"
                     if (!binding.deleteBut.isEnabled){
                         binding.deleteBut.isEnabled = true
                         binding.deleteBut.setBackgroundColor(ContextCompat.getColor(this,R.color.whiteback))
                     }
                 }

                 R.id.bu3 -> {
                     buClickValue += "3"
                     if (!binding.deleteBut.isEnabled){
                         binding.deleteBut.isEnabled = true
                         binding.deleteBut.setBackgroundColor(ContextCompat.getColor(this,R.color.whiteback))
                     }
                 }

                 R.id.bu4 -> {
                     buClickValue += "4"
                     if (!binding.deleteBut.isEnabled){
                         binding.deleteBut.isEnabled = true
                         binding.deleteBut.setBackgroundColor(ContextCompat.getColor(this,R.color.whiteback))

                     }
                 }

                 R.id.bu5 -> {
                     buClickValue += "5"
                     if (!binding.deleteBut.isEnabled){
                         binding.deleteBut.isEnabled = true
                         binding.deleteBut.setBackgroundColor(ContextCompat.getColor(this,R.color.whiteback))
                     }
                 }

                 R.id.bu6 -> {
                     buClickValue += "6"
                     if (!binding.deleteBut.isEnabled){
                         binding.deleteBut.isEnabled = true
                         binding.deleteBut.setBackgroundColor(ContextCompat.getColor(this,R.color.whiteback))
                     }
                 }

                 R.id.bu7 -> {
                     buClickValue += "7"
                     if (!binding.deleteBut.isEnabled){
                         binding.deleteBut.isEnabled = true
                         binding.deleteBut.setBackgroundColor(ContextCompat.getColor(this,R.color.whiteback))
                     }
                 }

                 R.id.bu8 -> {
                     buClickValue += "8"
                     if (!binding.deleteBut.isEnabled){
                         binding.deleteBut.isEnabled = true
                         binding.deleteBut.setBackgroundColor(ContextCompat.getColor(this,R.color.whiteback))
                     }
                 }

                 R.id.bu9 -> {
                     buClickValue += "9"
                     if (!binding.deleteBut.isEnabled){
                         binding.deleteBut.isEnabled = true
                         binding.deleteBut.setBackgroundColor(ContextCompat.getColor(this,R.color.whiteback))
                     }
                 }

                 R.id.buCos->{
                     buClickValue = if (binding.ShowNumber.text.toString().toDouble() in 0.0..360.0){
                         cos(binding.ShowNumber.text.toString().toDouble()*Math.PI/180).toString()
                     }else{
                         Toast.makeText(this,"the number should be enter 0 and 360",Toast.LENGTH_LONG).show()
                         "Error input !!"
                     }
                 }

                 R.id.buSin->{
                     buClickValue = if (binding.ShowNumber.text.toString().toDouble() in 0.0..360.0 && binding.ShowNumber.text.toString().toDouble()!=180.0){
                         sin(binding.ShowNumber.text.toString().toDouble()*Math.PI/180).toString()
                     }else if (binding.ShowNumber.text.toString().toDouble()==180.0){
                         "0.0"
                     } else{
                         Toast.makeText(this,"the number should be enter 0 and 360",Toast.LENGTH_LONG).show()
                         "Error input!!"
                     }
                 }

                 R.id.negBut->{
                     buClickValue = "${binding.ShowNumber.text.toString().toDouble()*-1}"
                 }

                 R.id.cotBut->{
                     buClickValue = (90- atan(binding.ShowNumber.text.toString().toDouble()) *180/Math.PI).toString()
                 }

                 R.id.SecBut->{
                   buClickValue= ((1/ sin(binding.ShowNumber.text.toString().toDouble())).toString())
                 }

                 R.id.tanBut->{
                     buClickValue = (atan(binding.ShowNumber.text.toString().toDouble())*180/Math.PI).toString()
                 }

                 R.id.buPlusMinus -> {
                     buClickValue = when {
                         buClickValue[0]=='-' -> {
                             buClickValue.substring(1)
                         }
                         buClickValue[0]=='+' -> {
                             "-"+buClickValue.substring(1)
                         }
                         else -> {
                             "-$buClickValue"
                         }
                     }
                     if (!binding.deleteBut.isEnabled){
                         binding.deleteBut.isEnabled = true
                         binding.deleteBut.setBackgroundColor(ContextCompat.getColor(this,R.color.whiteback))
                     }
                 }

                 R.id.XPow3 -> {
                     buClickValue = "${buClickValue.toDouble() * buClickValue.toDouble() * buClickValue.toDouble()}"
                     if (!binding.deleteBut.isEnabled){
                         binding.deleteBut.isEnabled = true
                         binding.deleteBut.setBackgroundColor(ContextCompat.getColor(this,R.color.whiteback))
                     }
                 }

                 R.id.Xpow2 -> {
                     buClickValue = "${buClickValue.toDouble() * buClickValue.toDouble()}"
                     if (!binding.deleteBut.isEnabled){
                         binding.deleteBut.isEnabled = true
                         binding.deleteBut.setBackgroundColor(ContextCompat.getColor(this,R.color.whiteback))
                     }
                 }

                 R.id.inverseX -> {
                     buClickValue = "${1 / buClickValue.toDouble()}"
                     if (!binding.deleteBut.isEnabled){
                         binding.deleteBut.isEnabled = true
                         binding.deleteBut.setBackgroundColor(ContextCompat.getColor(this,R.color.whiteback))
                     }
                 }

                 R.id.deleteBut -> when {
                     buClickValue.length > 1 -> {
                         buClickValue = buClickValue.substring(0, buClickValue.length - 1)
                     }
                     buClickValue.length ==1  -> {
                         buClickValue="0"
                         binding.deleteBut.isEnabled = false
                         Toast.makeText(this,"PLEASE ENTER A NUMBER FOR USE THIS OPTION AGAIN !!",Toast.LENGTH_LONG).show()
                         binding.deleteBut.setBackgroundColor(ContextCompat.getColor(this,R.color.yellow))
                         dot = false
                     }
                 }

                 R.id.pi -> {
                     buClickValue = if (buClickValue.isNotEmpty()) {
                         "${buClickValue.toDouble() + 3.142}"
                     } else {
                         "${3.142}"
                     }
                     if (!binding.deleteBut.isEnabled){
                         binding.deleteBut.isEnabled = true
                         binding.deleteBut.setBackgroundColor(ContextCompat.getColor(this,R.color.whiteback))
                     }
                 }

                 R.id.doublePi -> {
                     buClickValue = if (buClickValue.isNotEmpty()) {
                         "${buClickValue.toDouble() + 6.284}"
                     } else {
                         "${6.284}"
                     }
                     if (!binding.deleteBut.isEnabled){
                         binding.deleteBut.isEnabled = true
                         binding.deleteBut.setBackgroundColor(ContextCompat.getColor(this,R.color.whiteback))
                     }
                 }

                 R.id.buDot -> {
                     if (binding.ShowNumber.text.toString().length == 1 && binding.ShowNumber.text.toString() == "0") {
                         buClickValue += "0."
                         Toast.makeText(this, "please enter a num first for use this option!!", Toast.LENGTH_LONG).show()
                     } else if (binding.ShowNumber.text.toString().isNotEmpty() && binding.ShowNumber.text.toString() != "0"
                             && !binding.ShowNumber.text.toString().contains(".")) {
                         buClickValue += "."
                     }
                     if (!binding.deleteBut.isEnabled) {
                         binding.deleteBut.isEnabled = true
                         binding.deleteBut.setBackgroundColor(ContextCompat.getColor(this, R.color.whiteback))
                     }
                 }

                 R.id.LogBut -> {
                     if (!buClickValue.contains(".")) {
                         when (buClickValue.toInt()) {
                             0 -> buClickValue = "1.0"
                             1 -> buClickValue = "10.0"
                             -1 -> buClickValue = "0.1"
                             in 2..125 -> {
                                 for (i in 0 until buClickValue.toInt()) {
                                     char = '0'
                                     sumSign.add(char)
                                 }
                                 buClickValue = if (sumSign.size < 5) {
                                     var strFromList: String = sumSign.joinToString("")
                                     "1${strFromList}"
                                 } else {
                                     "1.0E${(sumSign.size)}"
                                 }
                             }
                             in -2 downTo -125 -> {
                                 for (j in -2 downTo buClickValue.toInt()) {
                                      char = '0'
                                      sumSign.add(char)
                                 }
                                 buClickValue = if (sumSign.size < 5) {
                                     var strFromList: String = sumSign.joinToString("")
                                     "0.${strFromList}1"
                                 } else {
                                     "1.0E${-(sumSign.size + 1)}"
                                 }
                             }
                         }
                         sumSign.removeAll(sumSign)
                     } else if (buClickValue.contains(".")) {
                         buClickValue = "0"
                         Toast.makeText(this, "The number must be an integer", Toast.LENGTH_LONG).show()
                     }
                     if (!binding.deleteBut.isEnabled){
                         binding.deleteBut.isEnabled = true
                         binding.deleteBut.setBackgroundColor(ContextCompat.getColor(this,R.color.whiteback))
                     }
                 }

                 R.id.factBut ->{
                     if (!buClickValue.contains(".")) {
                         when {
                             buClickValue=="1" -> {
                                 buClickValue ="1.0"
                             }
                             buClickValue.toInt()>1 -> {
                                 for (i in 1..buClickValue.toInt()){
                                     sumNum *= i
                                 }
                                 buClickValue="$sumNum"
                                 sumNum=1.0
                             }
                             buClickValue.toInt()<0->{
                                 buClickValue = "0.0"
                                 Toast.makeText(this, "The number must be positive", Toast.LENGTH_LONG).show()
                             }
                         }
                     }else if (buClickValue.contains(".")){
                         buClickValue = "0.0"
                         Toast.makeText(this, "The number must don't have a dot in it!!", Toast.LENGTH_LONG).show()
                     }
                 }
             }
        binding.ShowNumber.setText(buClickValue)
    }
    ////////////////////////////////////////////////////////
    fun buOperation(view: View) {
        val buSelect= view as Button
        var oldNum :String = binding.showOldNum.text.toString()
        when(buSelect.id) {
            R.id.buMul-> {
                
                   oldNum += binding.ShowNumber.text.toString() + "*"
                   oldNumber = binding.ShowNumber.text.toString().toDouble()
                   sumNumList.add(oldNumber)
                   sumSign.add('*')
            }

            R.id.buDiv-> {

                    oldNum += binding.ShowNumber.text.toString() + "/"
                    oldNumber = binding.ShowNumber.text.toString().toDouble()
                    sumNumList.add(oldNumber)
                    sumSign.add('/')
            }

            R.id.buSub-> {

                    oldNum += binding.ShowNumber.text.toString() + "-"
                    oldNumber = binding.ShowNumber.text.toString().toDouble()
                    sumNumList.add(oldNumber)
                    sumSign.add('-')
            }

            R.id.buSum-> {

                    oldNum += binding.ShowNumber.text.toString() + "+"
                    oldNumber = binding.ShowNumber.text.toString().toDouble()
                    sumNumList.add(oldNumber)
                    sumSign.add('+')
            }

            R.id.XpowY ->{
                        oldNum += binding.ShowNumber.text.toString() + "^"
                        oldNumber = binding.ShowNumber.text.toString().toDouble()
                        sumNumList.add(oldNumber)
                        sumSign.add('^')
            }
        }
        buEqual(sumSign,sumNumList)
        binding.showOldNum.setText(oldNum)
        binding.ShowNumber.setText("0")
        dot = false
    }
   ////////////////////////////////////////////////////////////
    @SuppressLint("SetTextI18n")
    private fun buEqual(sumSign:MutableList<Char>,sumNumList:MutableList<Double>) {
        binding.buEq.setOnClickListener {
           when {
                   binding.showOldNum.text.toString()=="" -> {
                   binding.ShowNumber.text = binding.ShowNumber.text
               }
               sumSign.size==1 -> {
                   when {
                       sumSign[0]=='+' -> {
                           binding.ShowNumber.setText("${oldNumber + binding.ShowNumber.text.toString().toDouble()}")
                           binding.showOldNum.setText("")
                       }
                       sumSign[0]=='-' -> {
                           binding.ShowNumber.setText("${oldNumber - binding.ShowNumber.text.toString().toDouble()}")
                           binding.showOldNum.setText("")
                       }
                       sumSign[0]=='*' -> {
                           binding.ShowNumber.setText("${oldNumber * binding.ShowNumber.text.toString().toDouble()}")
                           binding.showOldNum.setText("")
                       }
                       sumSign[0]=='/' -> {
                           binding.ShowNumber.setText("${oldNumber / binding.ShowNumber.text.toString().toDouble()}")
                           binding.showOldNum.setText("")
                       }
                       sumSign[0]=='^' -> {
                           when {
                               !binding.ShowNumber.text.toString().contains(".") -> {
                                   when(binding.ShowNumber.text.toString().toInt()) {
                                       0 -> {
                                           binding.ShowNumber.setText("1.0")
                                           binding.showOldNum.setText("")
                                       }

                                       1 -> {
                                           binding.ShowNumber.setText(oldNumber.toString())
                                           binding.showOldNum.setText("")
                                       }
                                       -1 -> {
                                           binding.ShowNumber.setText("${1 / oldNumber}")
                                           binding.showOldNum.setText("")
                                       }
                                       in 2..125 -> {
                                           for (i in 0 until binding.ShowNumber.text.toString().toInt()) {
                                               sumNum *= oldNumber
                                           }
                                           binding.ShowNumber.setText(sumNum.toString())
                                           binding.showOldNum.setText("")
                                           sumNum = 1.0
                                       }
                                       in -2 downTo -125 -> {
                                           for (j in 0 downTo (+(binding.ShowNumber.text.toString().toInt() + 1))) {
                                               sumNum *= (1 / oldNumber)
                                           }
                                           binding.ShowNumber.setText(sumNum.toString())
                                           binding.showOldNum.setText("")
                                           sumNum = 1.0
                                       }
                                   }
                               }
                               binding.ShowNumber.text.toString().contains(".") -> {
                                   binding.ShowNumber.text = binding.showOldNum.text
                                   binding.showOldNum.setText("")
                                   Toast.makeText(this,"you must enter an integer number!!",Toast.LENGTH_LONG).show()
                               }
                           }
                       }
                   }
                   oldNumber=0.0
                   sumNumList.removeAt(0)
                   sumSign.removeAt(0)
               }
              sumSign.size>1 -> {
                   for (i in 0 until sumSign.size){
                       when {
                           i<sumSign.size-1 -> {
                               when {
                                   sumSign[i] == '+' -> {
                                       sumNum = sumNumList[i] + sumNumList[i+1]
                                   }
                                   sumSign[i] == '-' -> {
                                       sumNum = sumNumList[i] - sumNumList[i+1]
                                   }
                                   sumSign[i] == '*' -> {
                                       sumNum = sumNumList[i] * sumNumList[i+1]
                                   }
                                   sumSign[i] == '/' -> {
                                       sumNum = sumNumList[i] / sumNumList[i+1]
                                   }
                                   sumSign[i] == '^' -> {
                                       when {
                                           sumNumList[i+1].toString().contains('.') -> {
                                               Toast.makeText(this,"you must enter an integer number!!",Toast.LENGTH_LONG).show()
                                           }
                                           !sumNumList[i+1].toString().contains('.') -> {
                                               when {
                                                   sumNumList[i+1].toInt()==0 -> {
                                                       sumNum=1.0
                                                   }
                                                   sumNumList[i+1].toInt()==1 -> {
                                                       sumNum = sumNum
                                                   }
                                                   sumNumList[i+1].toInt()==-1 -> {
                                                       sumNum = 1/sumNum
                                                   }
                                                   sumNumList[i+1].toInt()>1 -> {
                                                       for (j in 0 until sumNumList[i+1].toInt()) {
                                                           result *= sumNumList[i]
                                                       }
                                                       sumNum = result
                                                   }
                                                   sumNumList[i+1].toInt()<0 -> {
                                                       for (j in 0 until sumNumList[i+1].toInt()) {
                                                           result *= (1/sumNumList[i])
                                                       }
                                                       sumNum = result
                                                   }
                                               }
                                           }
                                       }
                                   }
                               }
                               sumNumList[i+1]=sumNum
                           }
                           i==sumSign.size-1 -> when {
                               sumSign[i] == '+' -> {
                                   sumNum = sumNumList[i] + binding.ShowNumber.text.toString().toDouble()
                               }
                               sumSign[i] == '-' -> {
                                   sumNum = sumNumList[i] - binding.ShowNumber.text.toString().toDouble()
                               }
                               sumSign[i] == '*' -> {
                                   sumNum = sumNumList[i] * binding.ShowNumber.text.toString().toDouble()
                               }
                               sumSign[i] == '/' -> {
                                   sumNum = sumNumList[i] / binding.ShowNumber.text.toString().toDouble()
                               }
                               sumSign[i]=='^'->{
                                   when {
                                       !binding.ShowNumber.text.toString().contains(".") -> {
                                           when(binding.ShowNumber.text.toString().toInt()) {
                                               0 -> {
                                                   sumNum =1.0
                                               }

                                               1 -> {
                                                   sumNum = sumNumList[i]
                                               }
                                               -1 -> {
                                                   sumNum = 1/sumNumList[i]
                                               }
                                               in 2..125 -> {
                                                   for (k in 0 until binding.ShowNumber.text.toString().toInt()) {
                                                       result *= sumNumList[i]
                                                   }
                                                   sumNum = result
                                               }
                                               in -2 downTo -125-> {
                                                   for (j in 0 downTo  (+(binding.ShowNumber.text.toString().toInt() + 1))) {
                                                       result *= (1/sumNumList[i])
                                                   }
                                                   sumNum = result
                                               }
                                           }
                                       }
                                       binding.ShowNumber.text.toString().contains(".") -> {
                                           binding.ShowNumber.text = binding.ShowNumber.text
                                           binding.showOldNum.text = binding.showOldNum.text
                                           Toast.makeText(this,"you must enter an integer number!!",Toast.LENGTH_LONG).show()
                                       }
                                   }
                               }
                           }
                       }
                   }
                  oldNumber=0.0
                  sumNumList.removeAll(sumNumList)
                  sumSign.removeAll(sumSign)
                   binding.ShowNumber.setText(sumNum.toString())
                   binding.showOldNum.setText("")
                   sumNum=1.0
               }
           }
       }
    }
    /////////////////////////////////////////////////////////
    fun buPercent(view: View) {
        val number = (  binding.ShowNumber.text.toString().toDouble())/100
        binding.ShowNumber.setText(number.toString())
    }
    ///////////////////////////////////////////////////////////
    fun buClean(view: View) {
        binding.ShowNumber.setText("0")
        dot = false
        if (!binding.deleteBut.isEnabled){
            binding.deleteBut.isEnabled = true
            binding.deleteBut.setBackgroundColor(ContextCompat.getColor(this,R.color.whiteback))
        }else{
            binding.showOldNum.setText("")
        }
    }
}

