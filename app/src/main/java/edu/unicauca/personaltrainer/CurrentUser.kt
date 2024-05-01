package edu.unicauca.personaltrainer

import androidx.lifecycle.ViewModel
import edu.unicauca.personaltrainer.Personalized.Exercise
import edu.unicauca.personaltrainer.Personalized.Routine
import edu.unicauca.personaltrainer.Personalized.SampleRoutines

class CurrentUser: ViewModel(){
    var routines:List<Routine> = SampleRoutines.routineSample
    var exercises:List<Exercise> = listOf()
    var option:Int = 0
}