require_relative 'text_editor'

def run_demo
  text_editor = TextEditor.new

  text_editor.insert('Hello, World!')
  text_editor.insert(' Appended change!!')
  text_editor.undo
  text_editor.redo
  text_editor.delete(5)
  text_editor.undo
  text_editor.redo
end

run_demo
