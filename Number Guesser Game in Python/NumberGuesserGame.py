import random

print("Number Guesser Game")
print("Choose any number from 1 to 6 ")
n = int(input("Enter your number: "))

x = int(random.randint(1,6))

if n == x:
    print("The number you guessed is correct!")
    print("Your Answer: " , n)
    print("Correct Answer: " , x)

#remember to change the elif statements if random range was changed
elif n < 1:
    print("The number you picked is below the range")

elif n > 6:
    print("The number you guessed is above the range")

else:
    print("The number you guessed is wrong. The correct answer is " , x)
