# 2.1: Supervised Learning

- The two tasks of supervised learning: regression and classification. Linear regression, loss functions, and gradient descent.
- In supervised learning problems, we start with a data set containing training examples with associated correct labels.
- predicting annual income based on the number of years of higher education. we’d like to build a model that approximates the relationship f between the number of years of higher education X and corresponding annual income Y.

```math
Y = f(X) + \varepsilon
```

X (input) = years of higher education
Y (output) = annual income
f = function describing the relationship between X and Y
$\varepsilon$ (epsilon) = random error term (positive or negative) with mean zero

$\varepsilon$ represents irreducible error in the model, which is a theoretical limit around the performance of your algorithm due to inherent noise in the phenomena you are trying to explain. For example, imagine building a model to predict the outcome of a coin flip.

- This approach is an example of engineering a solution (vs. learning a solution, as with the linear regression method described below).
- explicit rules-based programming doesn’t work well with complex data. Imagine trying to design an image classification algorithm made of if-then statements describing the combinations of pixel brightnesses that should be labeled “cat” or “not cat”.
- Supervised machine learning solves this problem by getting the computer to do the work for you. By identifying patterns in the data, the machine is able to form heuristics. The primary difference between this and human learning is that machine learning runs on computer hardware and is best understood through the lens of computer science and statistics, whereas human pattern-matching happens in a biological brain (while accomplishing the same goals).
- In supervised learning, the machine attempts to learn the relationship between income and education from scratch, by running labeled training data through a learning algorithm. This learned function can be used to estimate the income of people whose income Y is unknown, as long as we have years of education X as inputs. In other words, we can apply our model to the unlabeled test data to estimate Y.
- The goal of supervised learning is to predict Y as accurately as possible when given new examples where X is known and Y is unknown.