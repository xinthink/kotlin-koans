package iii_conventions

import util.TODO


class Invokable {
    private var counter = 0
    val numberOfInvocations: Int
        get() = counter

    operator fun invoke(): Invokable {
        counter += 1
        return this
    }
}

fun todoTask31(): Nothing = TODO(
    """
        Task 31.
        Change class Invokable to count the number of invocations (round brackets).
        Uncomment the commented code - it should return 4.
    """,
    references = { invokable: Invokable -> })

fun task31(invokable: Invokable): Int {
    return invokable()()()().numberOfInvocations
}
