#insert - вставить на текущую позицию list_name.insert(position,item)
#идея: вкладывать в список, использовать счётчик
#табуляцию счётчиком

yaml = []

file1 = open('C://Users/osink/Downloads/lab3.yaml')
s = file1.readlines()

now = 0 #счётчик позиции курсора

for i in range(1, len(s)): #цикл по длине массива со строками

    j = 0
    while not s[i][j].isalpha(): #удаляем всё из s, пока это не буква
        s[i] = s[i][j + 1:]
        j += 1

    s[i] = s[i][0:-1] #убираем /n

    j = 0
    while j < len(s[i]): #берём содержимое контейнера
        if s[i][j] == ":": #провряем, является ли итый житый элемент двоеточием

            if "'" in s[i]: #провряем, есть ли одинарные кавычки
                flag = False
                ind = "'".find(s[i]) #выводим индекс первого вхождения одинаковой кавычки
                next_str = "" # говорим, что тогда следующая строка равна пустому множеству
                s[i] = s[i][1:j] #убираем пропуск в начале строки с кавычкой

            else:
                flag = True
                next_str = s[i][j + 2:] #говорим, что следующая строка равна всему содержимому
                s[i] = s[i][:j] #текущая строка помещается в треугольнички
        j += 1
    current = "<" + s[i] + ">"

    if flag == True: # добавляем строку
        current = "<" + s[i] + ">" + next_str + "</" + current[1:]
        yaml.insert(now, count * 3 * " " + current)

    else: #добавляем блок
        count = 1
        yaml.append(count * 3 * " " + current)
        now = len(yaml)
        current = "</" + current[1:]
        yaml.append(count * 3 * " " + current)
        count += 1


first = "<" + s[0][:-2] + ">" # добавим первый и последний элемент
yaml.insert(0, first)
first = "</" + first[1:]
yaml.append(first)

for i in range(len(yaml)):
    print(yaml[i])





























'''
yaml = []
file1 = open('C://Users/osink/Downloads/lab3.yaml')
s = file1.readlines()
count = 0 # счётчик количества опущенных пробелов
for i in range(len(s)):
    count = 0
    j = 0 # идея: счётчик, который будет считать колво опущенных пробелов в строке
    while s[i][j] == "	" or s[i][j] == "-":
        if s[i][j] == "-": # убираем чёрточки
            s[i] = s[i][j + 1:]
            j += 1
        if s[i][j] == "	": # убираем пробелы
            count += 1
            s[i] = s[i][j + 1:]
    ans = "	" * count + "<" # составляем заготовку для строки
    for z in range(len(s[i]) - j):
        ans += s[i][z + j] # прибавляем
    ans = ans[0:-1]
    s[i] = ans + ">"
    print(s[i])


'''