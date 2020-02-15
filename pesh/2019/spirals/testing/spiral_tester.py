import cv2
import numpy as np
import argparse

parser = argparse.ArgumentParser()
parser.add_argument('--n', type=int, help='The size of the bounding square')
args = parser.parse_args()
n = args.n
arr = np.empty([n, n], dtype=int)
d = 1
E = 0
S = 1
W = 2
N = 2
x = int(n/2)
y = x
arr[x, y] = 255

status = True
while status:
    for i in range(d):
        x = x + 1
        y = y + 1
        if x < 0 or x >= n or y < 0 or y >= n:
            status = False
        else:
            arr[x, y] = 255
    if not status:
        break
    for i in range(E):
        x = x + 1
        if x < 0 or x >= n or y < 0 or y >= n:
            status = False
        else:
            arr[x, y] = 255
    if not status:
        break
    E = E + 2
    for i in range(d):
        x = x + 1
        y = y - 1
        if x < 0 or x >= n or y < 0 or y >= n:
            status = False
        else:
            arr[x, y] = 255
    if not status:
        break
    for i in range(S):
        y = y - 1
        if x < 0 or x >= n or y < 0 or y >= n:
            status = False
        else:
            arr[x, y] = 255
    if not status:
        break
    S = S + 2
    for i in range(d):
        y = y - 1
        x = x - 1
        if x < 0 or x >= n or y < 0 or y >= n:
            status = False
        else:
            arr[x, y] = 255
    if not status:
        break
    for i in range(W):
        x = x - 1
        if x < 0 or x >= n or y < 0 or y >= n:
            status = False
        else:
            arr[x, y] = 255
    if not status:
        break
    W = W + 2
    for i in range(d):
        x = x - 1
        y = y + 1
        if x < 0 or x >= n or y < 0 or y >= n:
            status = False
        else:
            arr[x, y] = 255
    if not status:
        break
    for i in range(N):
        y = y + 1
        if x < 0 or x >= n or y < 0 or y >= n:
            status = False
        else:
            arr[x, y] = 255
    if not status:
        break
    N = N + 2
    d = d + 1

arr = arr.astype(np.uint8)
cv2.imshow('arr', arr)
cv2.imwrite('sprial' + str(n) + '.png', arr)
cv2.waitKey(-1)