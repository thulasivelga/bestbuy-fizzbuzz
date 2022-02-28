Feature: Testing FizzBuzz application
Scenario Outline: validating FizzBuzz web application
    Given user in on the FizzBuzz application page
    When user enters "<input>" 
    Then verify "<column1>" ,"<column2>" are displayed in the table
    Examples: 
      | input      | column1     |      column2                           |  
 ############################################################################     
      |  1         |      1      |divided 1 by 3,divided 1 by 5           | 
      |  3         |      3      |fizz                                    | 
      |  5         |      5      |buzz                                    |
      |  ""        |      empty  |invalid item                            |
      |  15        |      15     |fizzbuzz                                |
      |  a         |      a      |invalid item                            |
      |  23        |      23     |divided 23 by 3,divided 23 by 5         |
      |  @         |      @      |invalid item                            |
      |  -1        |      -1     |invalid item                            |
      |  abc       |      abc    |invalid item                            |
      |  120       |      120    |fizzbuzz                                |
      |  3a        |      3a     |invalid item                            |
      |  1.9       |      1.9    |invalid item                            |
         
      
       

      
      