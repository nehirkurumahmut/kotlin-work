"""Lab 05 portfolio submission template (Exercise 1 code).

Submit this file, plus a separate .md or .txt file with your written
explanation, to Gradescope. Fill in the TODOs below - do not rename either
function, the autograder looks up `generate_table` by name.

What you need to do:
  1. Implement `gram_schmidt_qr`: the classical Gram-Schmidt QR
     factorisation, as covered in the lectures.
  2. Implement `generate_table`: build the eps/error1/error2/error3 table
     for eps = 10**-6, ..., 10**-16 using `gram_schmidt_qr`, and save it to
     "table.csv" in the working directory - the autograder looks for that
     exact filename, with a header row and columns named exactly
     eps, error1, error2, error3.
"""
# Student Name: Nehir Kurumahmut
# Student ID:201984143


import numpy as np


def A_func(eps):
    return np.array([[1, 1 + eps], [1 + eps, 1]], dtype=float)


def gram_schmidt_qr(A):
    """
    Compute the QR factorisation of a square matrix using the classical
    Gram-Schmidt process.

    Parameters
    ----------
    A : numpy.ndarray
        A square 2D NumPy array of shape ``(n, n)`` representing the input
        matrix.

    Returns
    -------
    Q : numpy.ndarray
        Orthonormal matrix of shape ``(n, n)`` where the columns form an
        orthonormal basis for the column space of A.
    R : numpy.ndarray
        Upper triangular matrix of shape ``(n, n)``.
    """
    n, m = A.shape
    if n != m:
        raise ValueError(f"the matrix A is not square, {A.shape=}")

    Q = np.empty_like(A)
    R = np.zeros_like(A)
    for j in range(n):
        v =  A[:,j].copy()
    for i in range(j):
        R[i,j] = np.dot(Q[:,i],A[:,j])
        v = v - R[i,j] * Q[:i]
    R[i,j] = np.linalg.norm(v)
    Q[:,j] = v / R[j,j]

    # TODO: fill in Q and R

    return Q, R


def generate_table():
    """
    Build the eps/error1/error2/error3 table for eps = 10**-6, ..., 10**-16
    using gram_schmidt_qr, and save it to "table.csv" (the autograder looks
    for this exact filename).
    """
    # TODO: build the table and save it, e.g.
    import pandas as pd
    #
    rows = []
    # for eps in [10**-j for j in range(6, 17)]:
    #     ...
    #     rows.append(
    #         {"eps": eps, "error1": error1, "error2": error2, "error3": error3}
    #     )
    # pd.DataFrame(rows).to_csv("table.csv", index=False)
    for j in range(6, 17):
      eps = (10.0 ** (-j))
      A = A_func(eps)
      Q, R = gram_schmidt_qr(A)
      error1 = np.linalg.norm(A - Q @ R)
      error2 = np.linalg.norm( Q.T @ Q - np.eye(A.shape[0]))
      error3 = np.linalg.norm(np.tril(R, -1))
      rows.append(
        {"eps": eps, "error1": error1, "error2": error2, "error3": error3}
       )
    pd.DataFrame(rows).to_csv("table.csv", index=False)
      
      

if __name__ == "__main__":
    generate_table()
