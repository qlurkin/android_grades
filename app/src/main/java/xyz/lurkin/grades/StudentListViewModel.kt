package xyz.lurkin.grades

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class StudentListViewModel : ViewModel() {
    val db = FirebaseFirestore.getInstance()

    val students = MutableLiveData<List<Student>>()

    init {
        Log.i("StudentListViewModel", "StudentListViewModel Created!")
        db.collection("students")
            .addSnapshotListener { result, e ->
                if(e != null) {
                    Log.w("StudentListViewModel", "Error getting documents.", e)
                    students.value = listOf()
                }

                if(result != null) {
                    var res = mutableListOf<Student>()
                    for (document in result) {
                        Log.d("StudentListViewModel", "${document.id} => ${document.data}")
                        //res += "${document.id} => ${document.data}\n"
                        res.add(Student(document.data["firstname"] as String, document.data["lastname"] as String, document.id))
                    }
                    students.value = res
                }
            }
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("StudentListViewModel", "StudentListViewModel Destroyed!")
    }
}