'''
 @source : https://www.acmicpc.net/problem/9536
 @email : ehye826@gmail.com
 @date : 2019.10.14
'''

def get_fox_sound(sound_list):
    sound_dict = {}
    for sound in sound_list:
        sound_dict[sound] = sound_dict.get(sound,0) + 1

    while True:
        info = input()
        if info == 'what does the fox say?':
            break
        sound = info.split(' ')[2]
        if sound in sound_dict:
            sound_dict[sound] = 0
    fox_sound = ''
    for sound in sound_list:
        if sound_dict[sound] > 0:
            fox_sound += '{0} '.format(sound)
            
    return fox_sound.strip()
        
    
if __name__ == "__main__":
    num_of_cases = int(input())
    for i in range(0, num_of_cases):
        
        fox_sound = get_fox_sound(input().split(' '))
        print(fox_sound)
    
    

