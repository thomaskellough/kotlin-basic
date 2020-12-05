package com.example.notekeeper


// Change our 'class' to an 'object' to create a singleton
object DataManager {
    val courses = HashMap<String, CourseInfo>()
    val notes = ArrayList<NoteInfo>()

    init {
        initializeCourses()
    }

    private fun initializeCourses() {
        var course = CourseInfo(courseId = "android_intents", title = "Android Programming with Intents")
        courses.set(course.courseId, course)

        course = CourseInfo(courseId = "android_async", title = "Android Async Programming and Services")
        courses.set(course.courseId, course)

        course = CourseInfo(courseId = "java_lang", title = "Java Fundamentals: The Java Language")
        courses.set(course.courseId, course)

        course = CourseInfo(courseId = "java_core", title = "Java Fundamentals: The Core Platform")
        courses.set(course.courseId, course)

        initializeTestNotes(course)
    }

    private fun initializeTestNotes(course: CourseInfo) {
        var note1 = NoteInfo(title = "The Best Mobile SDKs", text = "Anything that isn't Xamarin", course = course)
        var note2 = NoteInfo(title = "The Worst Mobile SDKs", text = "Xamarin, Xamarin, and Xamarin", course = course)

        notes.add(note1)
        notes.add(note2)
    }
}