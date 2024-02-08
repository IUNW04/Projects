
# I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
# Any code taken from other sources is referenced within my code solution.
# Student ID: .w1910647............................ # Date: ....26/08/2022.........................


Pass = ''
defer=''
fail=''
Total=Pass+defer+fail
enteragain=''
progress=0
trailer=0
retriever=0
exclude=0


while Pass or defer or fail is not int:
    try:
        Pass = int(input('Enter pass credit: '))
        if Pass not in range(0,121,20):
            print('Out of range')
            print('    ')
            continue
        defer = int(input('Enter defer credit: '))
        if defer not in range(0,121,20):
            print('Out of range')
            print('    ')
            continue
        fail = int(input('Enter fail credit: '))
        if fail not in range(0,121,20):
            print('Out of range')
            print('    ')
            continue
    
        Total=Pass+defer+fail
        Total=int(Total)
        
        

        if Total!=120:
            print('incorrect total')
            print('    ')
            continue

         
        
        elif Pass==120 and defer==0 and fail==0: 
           print('Progress')
           progress=progress+1
    
        elif Pass==100 and defer in range(0,21,20) and fail in range(0,21,20):
           print('Progress(module trailer)')
           trailer=trailer+1
           
        elif Pass in range(0,81,20) and defer in range(0,121,20) and fail in range(0,61,20):
            print('Module retriever')
            retriever=retriever+1
           
        elif Pass in range(0,41,20) and defer in range (0,41,20) and fail in range (0,121,20):
           print('Exclude')
           exclude=exclude+1
          
      
        if Total==120:
           print('    ')
           print('would you like to enter another set of data?')

        enteragain=input('Enter y for yes or q to quit and view results: ')
        print('  ')
        if enteragain=='q':
             print('    ')
             print('-------------------------------------------------')
             print('HISTOGRAM')
             print('Progress ',progress,': ',' *'*progress)
             print('Trailer ',trailer,': ',' *'*trailer)
             print('Retriever ',retriever,': ',' *'*retriever)
             print('Exclude ',exclude,': ',' *'*exclude)
             print('             ')
             print(progress+trailer+retriever+exclude,'Outcomes in total')
             print('-------------------------------------------------')           
             break
        while enteragain!='y':
            print('would you like to enter another set of data?')
            enteragain=input('Enter y for yes or q to quit and view results: ')
            print('   ')
            if enteragain=='q':
                  break
          
            
            
        if enteragain=='q':
             print('    ')
             print('-------------------------------------------------')
             print('HISTOGRAM')
             print('Progress ',progress,': ',' *'*progress)
             print('Trailer ',trailer,': ',' *'*trailer)
             print('Retriever ',retriever,': ',' *'*retriever)
             print('Exclude ',exclude,': ',' *'*exclude)
             print('             ')
             print(progress+trailer+retriever+exclude,'Outcomes in total')
             print('-------------------------------------------------')           
             break
        
        
      
            
  
    except ValueError:
        print('enter integers only')   
        print('    ')

data = []

# Loop to collect input data
while True:
  # Prompt user for input
  pass_credits = input("Enter your total PASS credits: ")
  defer_credits = input("Enter your total DEFER credits: ")
  fail_credits = input("Enter your total FAIL credits: ")
  
  # Add the input data to the list as a tuple
  data.append((pass_credits, defer_credits, fail_credits))
  
  # Prompt user to continue or quit
  response = input("Would you like to enter another set of data? Enter 'y' for yes or 'q' to quit and view results: ")
  if response == 'q':
    break

# Print the input data from the list
print("Part 2:")
for item in data:
  print("Progress - {}".format(item))



 

  
    
