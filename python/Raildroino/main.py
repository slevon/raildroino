#!/usr/bin/kivy

__author__ = 'slevon'

'''
This is the main entry point for Raildroino:
a Kivy/bluetooth interface for Railduino.

Railduino itself is a CAN interface project for an Arduino that interfaces Märklin Rails

This UI gives a List of all Trains, and a Tabview thar contains the Turnouts and Signals

Future Releases will contain an Edit Function that allows one to edit/add and delete new Trains, Turnouts
and signals directly from the UI
'''


from kivy.app import App
from kivy.uix.widget import Widget
from kivy.uix.slider import Slider
from kivy.uix.button import Button
from kivy.uix.boxlayout import BoxLayout
from kivy.properties import StringProperty



class Raildroino(Widget):


    def add(self):
        for i in range(5):
            print(i)
            self.ids.main_layout.add_widget(CntrlLoco(adress=str(i)))


class CntrlLoco(BoxLayout):
    adress = StringProperty('??')



class RaildroinoApp(App):
    def build(self):
        rd =  Raildroino()
        rd.add()
        return rd


if __name__ == '__main__':
    print("check")
    RaildroinoApp().run()